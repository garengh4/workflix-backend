package com.infy.workflixbackend2.entity;

import javax.persistence.*;

@Entity
@Table(name="file")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fileId;

    @Column(name = "file_name")
    private String fileName;
    @Column(name = "profile_id")
    private String profileId;
    @Column(name = "data")
    private String data;


}
