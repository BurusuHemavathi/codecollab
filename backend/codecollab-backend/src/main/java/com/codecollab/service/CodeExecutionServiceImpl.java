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

            FileWriter writer = new FileWriter(file);
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

            StringBuilder compileErrors =
                    new StringBuilder();

            String line;

            while ((line = compileError.readLine()) != null) {
                compileErrors.append(line)
                        .append("\n");
            }

            if (!compileErrors.isEmpty()) {
                return compileErrors.toString();
            }

            Process runProcess =
                    Runtime.getRuntime()
                            .exec("java Main");

            runProcess.waitFor();

            BufferedReader outputReader =
                    new BufferedReader(
                            new InputStreamReader(
                                    runProcess.getInputStream()
                            )
                    );

            BufferedReader errorReader =
                    new BufferedReader(
                            new InputStreamReader(
                                    runProcess.getErrorStream()
                            )
                    );

            StringBuilder output =
                    new StringBuilder();

            StringBuilder runtimeErrors =
                    new StringBuilder();

            while ((line = outputReader.readLine()) != null) {
                output.append(line)
                        .append("\n");
            }

            while ((line = errorReader.readLine()) != null) {
                runtimeErrors.append(line)
                        .append("\n");
            }

            if (!runtimeErrors.isEmpty()) {
                return runtimeErrors.toString();
            }

            return output.toString();

        } catch (Exception e) {

            return e.getMessage();
        }
    }
}