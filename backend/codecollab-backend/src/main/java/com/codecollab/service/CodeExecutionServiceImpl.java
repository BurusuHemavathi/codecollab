package com.codecollab.service;

import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class CodeExecutionServiceImpl
        implements CodeExecutionService {

    @Override
    public String executeJavaCode(String code) {

        try {

            File file = new File("Main.java");

            FileWriter writer =
                    new FileWriter(file);

            writer.write(code);
            writer.close();

            Process compileProcess =
                    Runtime.getRuntime()
                            .exec("javac Main.java");

            compileProcess.waitFor();

            BufferedReader compileError =
                    new BufferedReader(
                            new InputStreamReader(
                                    compileProcess.getErrorStream()
                            )
                    );

            StringBuilder errorOutput =
                    new StringBuilder();

            String line;

            while ((line = compileError.readLine())
                    != null) {

                errorOutput.append(line)
                        .append("\n");
            }

            if (!errorOutput.isEmpty()) {
                return errorOutput.toString();
            }

            Process runProcess =
                    Runtime.getRuntime()
                            .exec("java Main");

            BufferedReader outputReader =
                    new BufferedReader(
                            new InputStreamReader(
                                    runProcess.getInputStream()
                            )
                    );

            StringBuilder output =
                    new StringBuilder();

            while ((line = outputReader.readLine())
                    != null) {

                output.append(line)
                        .append("\n");
            }

            return output.toString();

        } catch (Exception e) {

            return e.getMessage();
        }
    }
}