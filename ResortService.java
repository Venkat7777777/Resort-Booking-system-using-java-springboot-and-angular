package com.examly.springapp.service;
import com.examly.springapp.model.Resort;
import java.util.List;

public interface ResortService {
    public Resort addResort(Resort resort);
    public List<Resort>getAllResorts();
    public Resort updateResort(Long id,Resort resort);
    public Resort deleteResort(Long id);
    public Resort getResortId(Long id);
}
