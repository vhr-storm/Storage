package com.example.storage.functional;

import com.example.storage.exception.ExistStorageException;
import com.example.storage.exception.NotExistStorageException;
import com.example.storage.model.Resume;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public abstract class AbstractStorage<SearchKey> implements Storage {
    static final Comparator<Resume> RESUME_COMPARATOR = ((o1, o2) -> o1.getFullName().compareTo(o2.getFullName()));

    abstract List<Resume> getAllResumes();

    abstract SearchKey getSearchKey(String uuid);

    abstract boolean isExist(SearchKey searchKey);

    abstract void doSave(Resume r, SearchKey searchKey);

    abstract Resume doGet(SearchKey searchKey);

    abstract void doDelete(SearchKey searchKey);

    abstract void doUpdate(Resume r, SearchKey searchKey);

    @DeleteMapping("/clear")
    @Override
    public void clear() {
        getAllResumes().clear();
    }

    @PostMapping("/save")
    @Override
    public void save(@RequestBody Resume r) {
        System.out.println("Saving resume: " + r.getUuid());

        SearchKey searchKey = getSearchKey(r.getUuid());

        if (isExist(searchKey)) {
            throw new ExistStorageException(r.getUuid());
        } else {
            doSave(r, searchKey);
        }

    }

    @GetMapping("/get")
    @Override
    public Resume get(@RequestParam("uuid") String uuid) {
        System.out.println("GET request received for UUID: " + uuid);

        SearchKey searchKey = getSearchKey(uuid);

        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }

        return doGet(searchKey);
    }

    @GetMapping("/get-all")
    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = getAllResumes();
        return list.stream()
                .sorted(RESUME_COMPARATOR)
                .collect(Collectors.toList());
    }

    @DeleteMapping("delete")
    @Override
    public void delete(@RequestParam String uuid) {
        SearchKey searchKey = getSearchKey(uuid);

        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }

        doDelete(searchKey);
    }

    @PutMapping("/update")
    @Override
    public void update(@RequestBody Resume r) {
        SearchKey searchKey = getSearchKey(r.getUuid());

        if (!isExist(searchKey)) {
            throw new NotExistStorageException(r.getUuid());
        }

        doUpdate(r, searchKey);
    }

    @GetMapping("/size")
    @Override
    public int size() {
        return getAllResumes().size();
    }

}
