package edu.miu.membership.modelmapper;

import edu.miu.membership.domain.*;
import edu.miu.membership.dto.*;

import java.util.stream.Collectors;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/15/22
 */

public class MapStruct {
    public TimeSlotDto convertToTimeSlotDto(TimeSlot timeSlot) {
        return new TimeSlotDto(
                timeSlot.getId(),
                timeSlot.getStartTime(),
                timeSlot.getEndTime(),
                timeSlot.getSlot(),
                timeSlot.getDay()
        );
    }
    public LocationDto convertToLocationDto(Location location){
        return new LocationDto(location.getId(),
                location.getName(),
                location.getDescription(),
                location.getCapacity(),
                location.getLocationType(),
                location.getTransactions().stream().map(this::convertToTransactionDto).collect(Collectors.toList()),
                location.getTimeSlots().stream().map(this::convertToTimeSlotDto).collect(Collectors.toSet())
        );
    }

    public TransactionDto convertToTransactionDto(Transaction transaction){
        return new TransactionDto(
                transaction.getId(),
                transaction.getCheckOut(),
                transaction.getCheckIn()
        );
    }
    public BadgeDto convertToBadgeDto(Badge badge) {
        return new BadgeDto(
                badge.getId(),
                badge.getIssueDate(),
                badge.getExpireDate(),
                badge.getBarcode(),
                badge.getStatus(),
                badge.getTransactions().stream().map(this::convertToTransactionDto).collect(Collectors.toList())

        );
    }
    public MemberDto convertToMemberDto(Member member){
        return new MemberDto(
                member.getId(),
                member.getFirstName(),
                member.getLastName(),
                member.getPhone(),
                member.getEmail(),
                member.getMemberships().stream().map(this::convertToMembershipDto).collect(Collectors.toSet()),
                member.getBadges().stream().map(this::convertToBadgeDto).collect(Collectors.toSet())
                //member.getPlans().stream().map(this::convertToPlanDto).collect(Collectors.toSet())
        );
    }
    public MembershipDto convertToMembershipDto(Membership membership){

        return new MembershipDto(
                membership.getId(),
                membership.getStartDate(),
                membership.getEndDate(),
                membership.getTransactions().stream().map(this::convertToTransactionDto).collect(Collectors.toList()));
    }

    public PlanDto convertToPlanDto(Plan plan) {
        return new PlanDto(
                plan.getId(),
                plan.getName(),
                plan.getDescription(),
                plan.getPlanType(),
                plan.getRole(),
                plan.getMemberships().stream().map(this::convertToMembershipDto).collect(Collectors.toSet()),
                plan.getLocations().stream().map(this::convertToLocationDto).collect(Collectors.toSet())
        );
    }
}
