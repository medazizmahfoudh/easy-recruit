package com.easyrecruit;

import net.thevpc.nuts.NApplication;
import net.thevpc.nuts.NWorkspace;
import net.thevpc.nuts.io.NPrintStream;
import net.thevpc.nuts.util.NMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EasyRecruitApplication implements NApplication {
    @Autowired
    private NWorkspace workspace;
    @Autowired
    private NPrintStream out;

    public static void main(String[] args) {
        SpringApplication.run(EasyRecruitApplication.class, args);
    }

    public void run() {
        String[] easyRecruit = {
                " EEEEE   AAAAA  SSSSS  Y   Y       RRRRR   EEEEE  CCCCC  RRRRR   U   U  IIIII  TTTTT ",
                " E       A   A  S       Y Y        R    R  E      C      R    R  U   U    I      T   ",
                " E       A   A  S        Y         R    R  E      C      R    R  U   U    I      T   ",
                " EEEE    AAAAA   SSSS     Y        RRRRR   EEEE   C      RRRRR   U   U    I      T   ",
                " E       A   A      S     Y        R   R   E      C      R   R   U   U    I      T   ",
                " E       A   A      S     Y        R    R  E      C      R    R  U   U    I      T   ",
                " EEEEE   A   A  SSSSS     Y        R     R EEEEE  CCCCC  R     R  UUU    IIIII   T   "
        };

        for (String line : easyRecruit) {
            out.println(line);
        }
        out.println("Easy Recruit Application");
        out.println(NMsg.ofC("Running Nuts %s %s %s %s %s %s",
                workspace.getRuntimeId().getVersion(),
                workspace.getPlatform(),
                workspace.getOs(),
                workspace.getOsDist(),
                workspace.getArch(),
                workspace.getDesktopEnvironment()
        ));
    }
}
