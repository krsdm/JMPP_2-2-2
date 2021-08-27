package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{
    private final CarDao carDao;

    @Autowired
    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> getCars(Integer count) {
//      если count равен null, т.е. запросили "/cars", или count > 4, возвращаю все машины
        if (Objects.isNull(count) || count > 4) {
            return carDao.getCars();
        }

//      если 0 < count < 5 возвращаю указанное кол-во машин
        if (count > 0 && count < 5) {
            return carDao.getCars().stream().limit(count).collect(Collectors.toList());
        }

//      иначе нужно верноуть HTTP Status 404, пока пусть будет пустой список
        return new ArrayList<>();
    }
}
