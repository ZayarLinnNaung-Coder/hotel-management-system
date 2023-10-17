package com.tcobep.solution.hms.configuration;

import com.tcobep.solution.hms.model.Authority;
import com.tcobep.solution.hms.model.Role;
import com.tcobep.solution.hms.repository.AuthorityRepository;
import com.tcobep.solution.hms.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;

    public DataInitializer(RoleRepository roleRepository, AuthorityRepository authorityRepository) {
        this.roleRepository = roleRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Define and save authorities
        Authority viewReservationDetails = new Authority("VIEW_RESERVATION_DETAILS");
        Authority checkIn = new Authority("CHECK_IN");
        Authority checkOut = new Authority("CHECK_OUT");
        Authority assignRoom = new Authority("ASSIGN_ROOM");
        Authority manageRoomAvailability = new Authority("MANAGE_ROOM_AVAILABILITY");
        Authority manageServiceRequests = new Authority("MANAGE_SERVICE_REQUESTS");
        Authority generateBills = new Authority("GENERATE_BILLS");
        Authority adjustBilling = new Authority("ADJUST_BILLING");
        Authority manageEmployeeAccounts = new Authority("MANAGE_EMPLOYEE_ACCOUNTS");
        Authority manageRoles = new Authority("MANAGE_ROLES");
        Authority systemConfiguration = new Authority("SYSTEM_CONFIGURATION");

        authorityRepository.saveAll(List.of(
                viewReservationDetails, checkIn, checkOut, assignRoom,
                manageRoomAvailability, manageServiceRequests, generateBills,
                adjustBilling, manageEmployeeAccounts, manageRoles, systemConfiguration
        ));

        // Define and save roles
        Role guestRole = new Role("ROLE_GUEST");
        guestRole.setDescription("This role is assigned to guests who have made reservations and are staying in the hotel.");
        guestRole.setAuthorities(List.of(viewReservationDetails, assignRoom));

        Role employeeRole = new Role("ROLE_EMPLOYEE");
        employeeRole.setDescription("This role is assigned to hotel staff members who work in various departments.");
        employeeRole.setAuthorities(List.of(
                viewReservationDetails, checkIn, checkOut, assignRoom,
                manageRoomAvailability, manageServiceRequests, generateBills
        ));

        Role managerRole = new Role("ROLE_MANAGER");
        managerRole.setDescription("This role is assigned to hotel managers responsible for overseeing operations.");
        managerRole.setAuthorities(List.of(
                viewReservationDetails, checkIn, checkOut, assignRoom,
                manageRoomAvailability, manageServiceRequests, generateBills, adjustBilling, manageEmployeeAccounts
        ));

        Role adminRole = new Role("ROLE_ADMIN");
        adminRole.setDescription("This role is assigned to system administrators with full access to the hotel management system.");
        adminRole.setAuthorities(List.of(
                viewReservationDetails, checkIn, checkOut, assignRoom,
                manageRoomAvailability, manageServiceRequests, generateBills,
                adjustBilling, manageEmployeeAccounts, manageRoles, systemConfiguration
        ));

        roleRepository.saveAll(List.of(guestRole, employeeRole, managerRole, adminRole));
    }
}

