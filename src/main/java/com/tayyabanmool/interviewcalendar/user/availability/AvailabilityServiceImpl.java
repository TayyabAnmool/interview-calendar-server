package com.tayyabanmool.interviewcalendar.service.availability;

import com.tayyabanmool.interviewcalendar.dto.availability.AvailabilityDto;
import com.tayyabanmool.interviewcalendar.dto.availability.CheckAvailabilityRequestDto;
import com.tayyabanmool.interviewcalendar.dto.availability.CheckAvailabilityResponseDto;
import com.tayyabanmool.interviewcalendar.dto.availability.AvailabilitySlotDto;
import com.tayyabanmool.interviewcalendar.entity.Availability;
import com.tayyabanmool.interviewcalendar.entity.User;
import com.tayyabanmool.interviewcalendar.enums.UserRole;
import com.tayyabanmool.interviewcalendar.exception.UserNotFoundException;
import com.tayyabanmool.interviewcalendar.repository.AvailabilityRepository;
import com.tayyabanmool.interviewcalendar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AvailabilityServiceImpl implements AvailabilityService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AvailabilityRepository availabilityRepository;

    /**
     * create a availability slot.
     *
     * @param availabilityDto to create new slot.
     * @return the persisted entity.
     */
    @Override
    public AvailabilityDto createOrUpdateAvailabilitySlot(AvailabilityDto availabilityDto) {
        Optional<User> optionalUser = userRepository.findById(availabilityDto.getUserId());
        AvailabilityDto availabilityDtoToReturn = null;
        if(optionalUser.isPresent()){
            User user = optionalUser.get();

            Optional<Availability> optionalAvailability = availabilityRepository.
                    findByDateAndUser(availabilityDto.getDate(), user);

            Availability availability;
            if(optionalAvailability.isPresent()){
                availability = optionalAvailability.get();
            }else{
                availability = new Availability();
                availability.setUser(user);
            }
            availability.getEntity(availabilityDto);
            availabilityDtoToReturn = availabilityRepository.save(availability).getDto();
        }else{
            throw new UserNotFoundException(availabilityDto.getUserId());
        }
        return availabilityDtoToReturn;
    }

    /**
     * check a availability slots.
     *
     * @param checkAvailabilityRequestDto to create new slot.
     * @return all available slots by interviewers.
     */
    @Override
    public List<CheckAvailabilityResponseDto> checkAvailabilitySlot(CheckAvailabilityRequestDto checkAvailabilityRequestDto) {
        Optional<User> optionalCandidate = userRepository.
                findByIdAndAndUserRole(checkAvailabilityRequestDto.getCandidateId(), UserRole.CANDIDATE);
        List<CheckAvailabilityResponseDto> availabilityResponseDtos = new ArrayList<>();
        if(optionalCandidate.isPresent()){
            User candidate = optionalCandidate.get();
            List<User> interviewers = userRepository.
                    findAllByIdInAndUserRole(checkAvailabilityRequestDto.getInterviewerIds(), UserRole.INTERVIEWER);

            candidate.getAvailabilityList().forEach(candidateAvailability -> {
                interviewers.forEach(i -> {
                    CheckAvailabilityResponseDto availabilityResponseDto = new CheckAvailabilityResponseDto();
                    availabilityResponseDto.setInterviewerName(i.getName());
                    List<Availability> matchedDateAvailabilities = i.getAvailabilityList().stream().filter(
                            a -> a.getDate().equals(candidateAvailability.getDate())).collect(Collectors.toList());
                    if(matchedDateAvailabilities.size()>0){
                        availabilityResponseDto.setAvailabilitySlotDtos(getDateAvailability(candidateAvailability,matchedDateAvailabilities));
                        availabilityResponseDtos.add(availabilityResponseDto);
                    }
                });
            });
            return availabilityResponseDtos;
        }else{
            throw new UserNotFoundException(checkAvailabilityRequestDto.getCandidateId());
        }
    }

    /**
     * calculate all matched slots.
     *
     * @param candidateAvailability candidate slots .
     * @param interviewerAvailability interviewer available slots per day.
     * @return list of all possible slots.
     */
    List<AvailabilitySlotDto> getDateAvailability(Availability candidateAvailability, List<Availability> interviewerAvailability){
        List<AvailabilitySlotDto> availabilities = new ArrayList<>();
        interviewerAvailability.forEach(availability ->
            availabilities.addAll(this.getHoursAvailabilitySlots(candidateAvailability,availability)));
        return availabilities;
    }

    /**
     * calculate matched hour slots in one day.
     *
     * @param candidateAvailability candidate slots .
     * @param interviewerAvailability interviewer available slots per day.
     * @return list of matched slots per day.
     */
    List<AvailabilitySlotDto> getHoursAvailabilitySlots(Availability candidateAvailability, Availability interviewerAvailability){
        List<AvailabilitySlotDto> availabilitySlotDtos = new ArrayList<>();

        int firstPossibleHour = Math.max(candidateAvailability.getHourFrom(), interviewerAvailability.getHourFrom());
        int lastPossibleHour = Math.min(candidateAvailability.getHourTo(), interviewerAvailability.getHourTo());
        while (firstPossibleHour < lastPossibleHour) {
            availabilitySlotDtos.add(new AvailabilitySlotDto(firstPossibleHour, firstPossibleHour+1, candidateAvailability.getDate()));
            firstPossibleHour++;
        }
        return availabilitySlotDtos;
    }
}
