package com.mustafaiev.store;

import java.io.*;

/**
 * Created by user on 09.07.2015.
 */
public class ConnectionData {
    private String URL;
    private String USERNAME;
    private String PASSWORD;
    private String DRIVER;

    public String getURL() {
        return URL;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getDRIVER() {
        return DRIVER;
    }

    private static String fileName = "F://Java/Task/departmentStaffInfo/dataBaseConnectionInfo.txt";

    static File file = new File(fileName);

    public String read() throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        exist();

        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    s = s.trim();
                    sb.append(s);
                    sb.append(" ");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();

    }

    private void exist() throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }

    public void loadConnectionData() throws FileNotFoundException {
        String textFromFile = read();
        String data[] = textFromFile.split(" ");
        URL = data[0].trim();
        USERNAME = data[1].trim();
        PASSWORD = data[2].trim();
        DRIVER = data[3].trim();

    }
}
