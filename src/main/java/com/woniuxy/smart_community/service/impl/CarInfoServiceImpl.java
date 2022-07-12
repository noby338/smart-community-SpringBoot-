package com.woniuxy.smart_community.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.dao.CarInfoDao;
import com.woniuxy.smart_community.dao.OwnerInfoDao;
import com.woniuxy.smart_community.dao.ParkingInfoDao;
import com.woniuxy.smart_community.entity.CarInfo;
import com.woniuxy.smart_community.entity.ForSelect;
import com.woniuxy.smart_community.entity.OwnersInfo;
import com.woniuxy.smart_community.entity.ParkingInfo;
import com.woniuxy.smart_community.service.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author LittleCode
 * @Date 2022/7/6 17:57
 */
@Service
public class CarInfoServiceImpl implements CarInfoService {
    @Autowired
    CarInfoDao carInfoDao;
    @Value("${view.carJpg}")
    private String carJpgPre;

    @Autowired
    ParkingInfoDao parkingInfoDao;
    @Autowired
    OwnerInfoDao ownerInfoDao;

    @Override
    public PageInfo<CarInfo> getAllCarInfo(int pageIndex,int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<CarInfo> carInfos=carInfoDao.selectAllCarInfos();
        for(CarInfo carInfo:carInfos){
            String carJpg = carInfo.getCarJpg();
            if(carJpg!=null){
                carInfo.setCarJpg(carJpgPre+carJpg);
            }
        }
        PageInfo<CarInfo> pageInfo=new PageInfo<>(carInfos);
        int total=carInfoDao.selectCountCarInfo();
        pageInfo.setTotal(total);
        return pageInfo;
    }

    @Override
    public List<ForSelect> getALLParkingInfoIdAndParkNumber(int id) {
        List<ForSelect> forSelects=new ArrayList<ForSelect>();
        List<ParkingInfo> parkingInfos=parkingInfoDao.selectParkingInfoByParkingInfo(null);

        for(ParkingInfo parkingInfo:parkingInfos){
            ForSelect forSelect=new ForSelect();
            forSelect.setValue(parkingInfo.getId());
            forSelect.setLabel(parkingInfo.getParkNumber());
            if(parkingInfo.getOwnersInfo()!=null){
                forSelect.setDisabled(true);
            }
            if(parkingInfo.getId()==id){
                forSelect.setLabel(parkingInfo.getParkNumber()+"(当前使用)");
            }
            forSelects.add(forSelect);
        }
        return forSelects;
    }
    @Override
    public List<ForSelect> getAllCarOwnersIdAndName(int id) {
        List<ForSelect> forSelects=new ArrayList<ForSelect>();
        List<OwnersInfo> ownersInfos=ownerInfoDao.selectAllOwners();
        for(OwnersInfo ownersInfo:ownersInfos){
            ForSelect forSelect=new ForSelect();
            forSelect.setValue(ownersInfo.getId());
            forSelect.setLabel(ownersInfo.getName()+"("+ownersInfo.getTelephone()+")");
            if(ownersInfo.getId()==id){
                forSelect.setLabel(ownersInfo.getName()+"(当前使用)");
                forSelect.setDisabled(true);
            }
            forSelects.add(forSelect);
        }
        return forSelects;
    }


    @Override
    public void addImgAddress(String carNumber, String imgAddress) {
        carInfoDao.updateImgByCarNumber(carNumber,imgAddress);
    }

}
