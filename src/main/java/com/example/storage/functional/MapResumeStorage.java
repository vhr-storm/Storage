package com.example.storage.functional;

import com.example.storage.model.Resume;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/map-resume")
public class MapResumeStorage extends AbstractStorage<Resume> {
    private final Map<String, Resume> MAP_RESUME = new HashMap<>();

    @Override
    public void clear() {
        MAP_RESUME.clear();
    }

    @Override
    protected List<Resume> getAllResumes() {
        return new ArrayList<>(MAP_RESUME.values());
    }

    @Override
    Resume getSearchKey(String uuid) {
        return new Resume(uuid, "dummy");
    }

    @Override
    boolean isExist(Resume searchKey) {
        return MAP_RESUME.containsKey(searchKey.getUuid());
    }

    @Override
    void doSave(Resume r, Resume searchKey) {
        MAP_RESUME.put(searchKey.getUuid(), r);
    }

    @Override
    Resume doGet(Resume searchKey) {
        return MAP_RESUME.get(searchKey.getUuid());
    }

    @Override
    void doDelete(Resume searchKey) {
        MAP_RESUME.remove(searchKey.getUuid());
    }

    @Override
    void doUpdate(Resume r, Resume searchKey) {
        MAP_RESUME.put(searchKey.getUuid(), r);
    }
}
