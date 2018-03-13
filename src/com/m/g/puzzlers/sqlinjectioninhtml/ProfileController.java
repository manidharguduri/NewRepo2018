package com.m.g.puzzlers.sqlinjectioninhtml;
/**
 *

        import javax.persistence.EntityManager;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.http.HttpSession;
        import javax.validation.Valid;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.transaction.annotation.Transactional;
        import org.springframework.ui.Model;
        import org.springframework.util.StringUtils;
        import org.springframework.validation.BindingResult;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.servlet.mvc.support.RedirectAttributes;

        import challenge.domain.User;
        import challenge.form.EditProfileForm;
        import challenge.service.PasswordEncodingService;


/**
 *
 * Allow an authenticated user to manage its profile.
 *
 * @author mdelorenzo
 *


@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired EntityManager em;
    @Autowired PasswordEncodingService passwordEncoder;


    @RequestMapping(method=RequestMethod.GET)
    public String showForm(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        User user;

        user = (User) session.getAttribute("user");
        if (user==null) {
            return "redirect:/login";
        }

        EditProfileForm form = new EditProfileForm(user);
        model.addAttribute("form", form);
        return "profile";
    }

    @Transactional
    @RequestMapping(method=RequestMethod.POST)
    public String update(@Valid EditProfileForm form, BindingResult binding, HttpSession session, RedirectAttributes redir){
        User user;

        user = (User) session.getAttribute("user");
        if (user==null) {
            return "redirect:/login";
        }

        if (binding.hasErrors()) {
            redir.addFlashAttribute("validationErrors", binding.getAllErrors());
            return "redirect:/profile";
        }

        final String encodedPassword = passwordEncoder.encode(form.getPassword());
        if (!user.getPassword().equals(encodedPassword)) {
            redir.addFlashAttribute("errorMessage", "Invalid password.");
            return "redirect:/profile";
        }

        try {

*************************************************************************************************************

================= problem code start =====================
            String dml = "update user set first_name = '"+form.getFirstName()+"', last_name = '"+form.getLastName()+"' ";

            if (!StringUtils.isEmpty(form.getNewPassword())) {
                dml += ", password = '"+passwordEncoder.encode(form.getNewPassword())+"' ";
            }
            dml += " where id = "+user.getId();

            em.createNativeQuery(dml).executeUpdate();

            session.setAttribute("user", em.find(User.class, user.getId()));

Problem Description: Using native query with string concatenation allows for SQL Injection attack.

================= problem code end =====================


================= better code start =====================

try {
user = em.find(User.class, user.getId());
user.setFirstName(form.getFirstName());
user.setLastName(form.getLastName());

if (!StringUtils.isEmpty(form.getNewPassword())) {
user.setPassword(passwordEncoder.encode(form.getNewPassword()));
}
em.merge(user);
session.setAttribute("user", user);
}

Solution Description:
The secure solution is making proper use of persistence API's (JPA/JDBC or your favourite framework of choice) that will take proper care of dealing with escaping potentially malicious values.

================= better code end =======================

 *************************************************************************************************************

        }
        catch (Exception e) {
            redir.addFlashAttribute("form", form);
            redir.addFlashAttribute("errorMessage", "There was an error updating your profile. Try again later.");
            return "redirect:/register";
        }

        redir.addFlashAttribute("successMessage", "Your profile's been updated successfully.");
        return "redirect:/profile";
    }

}
 */