package my.edu.umk.pams.intake.policy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PAMS
 */
public enum Data {
    MOA("cps", "MASTER OF ARTS", "Master dalam Seni"),
    MOS("cps", "MASTER OF SCIENCE", "Master dalam Sains"),
    MOSETH("cps", "Master of Science Energy Technology", "Master dalam Sains Tenaga Teknologi"),

    MOSG("mgseb", "Master of Science Geoscience", "Master dalam Geosain"),
    MOSET("mgseb", "Master of Science Energy Technology", "Master dalam Sains Tenaga Teknologi"),
    MOSETW("mgseb", "Master of Arts", "Master dalam Seni");

    public String admin;
    public String descriptionEn;
    public String descriptionMs;

    private static final Logger LOG = LoggerFactory.getLogger(Data.class);

    Data(String admin, String descriptionEn, String descriptionMs) {
        this.admin = admin;
        this.descriptionEn = descriptionEn;
        this.descriptionMs = descriptionMs;
    }

    public static List<Data> codesCPS() {
        return codes("cps");
    }

    public static List<Data> codesMGSEB() {
        return codes("mgseb");
    }

    public static List<Data> codes(String admin) {
        List<Data> output = new ArrayList<>();

        for (Data data : values())
            if (data.admin.equals(admin))
                output.add(data);

        return output;
    }
}
