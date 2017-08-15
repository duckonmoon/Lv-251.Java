package com.softserve.edu.lv251.constants;

/**
 * Created by Marian Brynetskyi on 14.08.2017.
 */
public interface Constants {

    String BASE_PACKAGE = "com.softserve.edu.lv251";
    String MESSAGES_SOURCE = "classpath:messages";
    String HOME = "http://localhost:8080";

    interface DatabaseConstants {
        String DATABASE_PROPERTY_SOURCE = "classpath:db.properties";
    }

    interface MailConstants {
        String MAIL = "lv251clinics@gmail.com";
        String PASSWORD = "clinics251lv";
        String HOST = "smtp.gmail.com";
        int PORT = 587;
    }

    interface Controllers {
        String DATE_FLAG = "flag";
        String LOGIN_FLAG = "flag";
        String DOCTOR_ID = "doctorId";
        String NUMBER_CHAIN = "numberChain";
        String MESSAGE = "message";
        String CLASS_CSS = "classCss";
        String DOC_APPS = "docApps";
        String PHOTO = "photo";
        String PERSONAL_INFO_DTO = "personalInfoDTO";
        String DOCTORS = "doctors";
        String MODERATOR = "moderator";
        String USER_FORM = "userForm";
        String DOCTOR_FORM = "doctorForm";
        String EMAIL = "email";
        String CURRENT = "current";
        String USERS_TO_DOCTOR = "usersToDoctor";
        String PASSWORD_DTO = "passwordDTO";
        String GET_DOCTORS = "getDoctors";
        String PHOTO_FORM = "photoForm";
        String CLINIC_DTO = "clinicDTO";
        String ALL_DOCTORS = "allDoctors";
        String MODERATOR_CABINET = "moderatorCabinet";
        String MODERATOR_CABINET_DOCTORS = "moderatorCabinetDoctors";
        String MODERATOR_ADD_DOCTOR = "moderatorAddDoctor";
        String MODERATOR_MAKE_DOCTOR= "moderatorMakeDoctor";

    }

//    interface ControllersReturn {
//        String ALL_DOCTORS = "allDoctors";
//        String DOCTOR_DETAILS = "doctor_details";
//        String MODERATOR_CABINET = "moderatorCabinet";
//        String MODERATOR_CABINET_DOCTORS = "moderatorCabinetDoctors";
//        String MODERATOR_ADD_DOCTOR = "moderatorAddDoctor";
//        String MODERATOR_MAKE_DOCTOR= "moderatorMakeDoctor";
//        String MODERATOR_CABINET_URL= "/moderator/cabinet";
//        String MODERATOR_CABINET_DOCTORS_URL=":/moderator/cabinet/doctors";
//    }
}