package my.edu.umk.pams.intake.util;

import my.edu.umk.pams.intake.identity.model.InGroup;
import my.edu.umk.pams.intake.identity.model.InUser;
import org.joda.time.LocalDate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public class Util {

    public static Integer getCurrentYear() {
        return new LocalDate().getYear();
    }

    public static InUser getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            return ((my.edu.umk.pams.intake.security.integration.InUserDetails) auth.getPrincipal()).getUser();
        } else {
            return null;
        }
    }

    /**
     * Returns the given string if it is nonempty; {@code N/A string} otherwise.
     *
     * @param string the string to test and possibly return
     * @return {@code string} itself if it is nonempty; {@code 'N/A'} if it is
     * empty or null
     */
    public static String toNotApplicable(String string) {
        return (string == null) ? "N/A" : string;
    }

    public static String toEmpty(String string) {
        return (string == null) ? "" : string;
    }

    public static String toWildcard(Object obj) {
        return (obj.toString() == null) ? "%" : obj.toString();
    }

    public static Set<String> toString(Set<InGroup> groups) {
        Set<String> str = new HashSet<>();
        for (InGroup group : groups) {
            str.add(group.getName());
        }
        return str;
    }
}
