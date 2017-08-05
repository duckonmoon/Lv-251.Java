package com.softserve.edu.lv251.controllers;
import com.softserve.edu.lv251.dto.pojos.DoctorImageDTO;
import com.softserve.edu.lv251.entity.Appointments;
import com.softserve.edu.lv251.entity.Doctors;
import com.softserve.edu.lv251.service.AppointmentService;
import com.softserve.edu.lv251.service.DoctorsService;
import com.softserve.edu.lv251.service.PagingSizeService;
import com.softserve.edu.lv251.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Yana on 23.07.2017.
 */
@Controller
public class AllDoctorsController {

    @Autowired
    private DoctorsService doctorsService;

    @Autowired
    @Qualifier("doctorService")
    private PagingSizeService<Doctors> pagingSizeService;

    @Autowired
    private UserService userService;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private Logger logger;


    @RequestMapping(value = "/allDoctors/{current}",method = RequestMethod.GET)
    public  String allDoctors(@PathVariable("current") Integer chainIndex, Model model) {
        model.addAttribute("getDoctors", pagingSizeService.getEntity(chainIndex, 10));
        model.addAttribute("numberChain", pagingSizeService.numberOfPaging(10));
        return "allDoctors";
    }

    @RequestMapping(value = "/allDoctors/{flag}/{docId}", method = RequestMethod.GET)
    public String allDoctors(Model model, @PathVariable(value = "flag") boolean flag,
                             @PathVariable(value = "docId") long docId) {
        model.addAttribute("doctors", doctorsService.getAll());
        model.addAttribute("flag", true);
        model.addAttribute("doc", docId);
        return "allDoctors";
    }


    /**
     * Created by Marian Brynetskyi
     * @param modelMap
     * @param localdate
     * @param doctorId
     * @param principal
     * @return
     */
    @RequestMapping(value = "/user/addAppointment", method = RequestMethod.POST)
    public String addAppointment(Model modelMap, @RequestParam("datetime") String localdate,
                                 @RequestParam("doctorId") long doctorId,
                                 @RequestParam("current") Integer chainIndex, Principal principal) {

        Date date;

        try {
            date = new SimpleDateFormat("dd/MM/yyyy - HH:mm").parse(localdate);
            if(date.before(new Date())){
                throw new Exception();
            }
            Appointments appointments = new Appointments();
            appointments.setAppointmentDate(date);
            appointments.setApproved(false);
            appointments.setUsers(userService.findByEmail(principal.getName()));
            appointments.setDoctors(doctorsService.find(doctorId));
            appointmentService.addAppointment(appointments);

        } catch (Exception e) {
            logger.info("Wrong date.",e);
            modelMap.addAttribute("flag", true);
            modelMap.addAttribute("doc", doctorId);
            modelMap.addAttribute("current", chainIndex);
            return allDoctors(chainIndex, modelMap);
        }
        return allDoctors(chainIndex, modelMap);
    }

    @ResponseBody
    @RequestMapping(value = "/all/doc")
    public List<Doctors> searchDoctors(@RequestParam String name) {
        System.out.println(name);
        System.out.println(doctorsService.searchByLetters("Zyrr"));
        System.out.println(doctorsService.searchByLetters(name));
        return doctorsService.searchByLetters(name);

    }

    @ResponseBody
    @RequestMapping(value = "/search/{name}")
    public List<Doctors> searchAll(@PathVariable("name") String name) {
        System.out.println("in search ");
        System.out.println(name);
        return doctorsService.searchByLetters(name);

    }

    @ResponseBody
    @RequestMapping(value = "/searchResult/{id}")
    public Doctors s(@PathVariable Long id) {
        return doctorsService.find(id);
    }

    @RequestMapping(value = "/doctors/{id}", method = RequestMethod.GET)
    public String Doctor(@PathVariable Long id, Model model) {
        model.addAttribute("doctor", DoctorImageDTO.convert(doctorsService.find(id)));
        return "doctor_details";
    }


}
