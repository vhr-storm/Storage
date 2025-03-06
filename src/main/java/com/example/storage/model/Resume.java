package com.example.storage.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter

public class Resume implements Comparable<Resume> {
    private final String uuid;
    private final String fullName;

    @JsonCreator
    public Resume(
            @JsonProperty("uuid") String uuid,
            @JsonProperty("fullName") String fullName
    ) {
        this.uuid = uuid;
        this.fullName = fullName;
    }
    @Override
    public String toString() {
        return uuid + " " + fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid);
    }
    @JsonAnyGetter
    public Map<String, String> toMap() {
        return Collections.singletonMap(uuid, fullName);
    }

    @Override
    public int hashCode() {
        return uuid != null ? uuid.hashCode() : 0;
    }
    @Override
    public int compareTo(Resume o) {
        return this.uuid.compareTo(o.uuid);
    }
}
