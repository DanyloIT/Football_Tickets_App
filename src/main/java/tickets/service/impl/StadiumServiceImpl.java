package tickets.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import tickets.dao.StadiumDao;
import tickets.exception.DataProcessingException;
import tickets.model.Stadium;
import tickets.service.StadiumService;

@Service
public class StadiumServiceImpl implements StadiumService {
    private final StadiumDao stadiumDao;

    public StadiumServiceImpl(StadiumDao stadiumDao) {
        this.stadiumDao = stadiumDao;
    }

    @Override
    public Stadium add(Stadium stadium) {
        return stadiumDao.add(stadium);
    }

    @Override
    public Stadium get(Long id) {
        return stadiumDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get stadium with id = " + id));
    }

    @Override
    public List<Stadium> getAll() {
        return stadiumDao.getAll();
    }
}
