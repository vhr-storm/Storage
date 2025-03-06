package com.example.storage.functional;

import com.example.storage.model.Resume;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/list")
public class ListStorage extends AbstractStorage<Integer> {
    private static final List<Resume> LIST_RESUME = new ArrayList<>();

    @Override
    public void clear() {
        LIST_RESUME.clear();
    }

    @Override
    protected List<Resume> getAllResumes() {
        return LIST_RESUME;
    }

    @Override
    Integer getSearchKey(String uuid) {
        return LIST_RESUME.indexOf(new Resume(uuid, "dummy"));
    }

    @Override
    boolean isExist(Integer searchKey) {
        return searchKey >= 0;
    }

    @Override
    void doSave(Resume r, Integer searchKey) {
        LIST_RESUME.add(r);
    }

    @Override
    Resume doGet(Integer searchKey) {
        return LIST_RESUME.get(searchKey);
    }

    @Override
    void doDelete(Integer searchKey) {
        LIST_RESUME.remove((int) searchKey);
    }

    @Override
    void doUpdate(Resume r, Integer searchKey) {
        LIST_RESUME.set(searchKey, r);
    }

}
