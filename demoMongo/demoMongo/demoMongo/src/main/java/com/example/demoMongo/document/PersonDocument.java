package com.example.demoMongo.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "collectiondemo")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PersonDocument {

    private Long id;
    private String firstName;
    private String lastName;
}
