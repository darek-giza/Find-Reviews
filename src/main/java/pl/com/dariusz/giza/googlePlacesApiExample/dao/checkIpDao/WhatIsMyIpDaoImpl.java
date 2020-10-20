package pl.com.dariusz.giza.googlePlacesApiExample.dao.checkIpDao;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Logger;

@Service
public class WhatIsMyIpDaoImpl implements WhatIsMyIpDao {


    public String whatIsMyIp() throws IOException {
        URL checkIP = new URL("http://checkip.amazonaws.com/");
        BufferedReader in = new BufferedReader(new InputStreamReader(checkIP.openStream()));
        String ip = in.readLine();
        Logger.getLogger("LOG").info("host " + ip);
        return ip;
    }
}
