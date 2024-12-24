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

    @Override
    public void run() {
        out.println("Hello ##Nuts## World!...");
        out.println(NMsg.ofC("we are running Nuts %s %s %s %s %s %s",
                workspace.getRuntimeId().getVersion(),
                workspace.getPlatform(),
                workspace.getOs(),
                workspace.getOsDist(),
                workspace.getArch(),
                workspace.getDesktopEnvironment()
        ));
    }
}
