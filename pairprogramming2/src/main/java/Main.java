package java;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String filePath="src/main/resources/data.json";

        ObjectMapper objectMapper=new ObjectMapper();

        JsonNode root=objectMapper.readTree(new File(filePath));

        EmployeeJsonUpdate.jsonUpdate(root,"name","someswari");

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath),root);

        System.out.println("data updated successfully");
    }

}
