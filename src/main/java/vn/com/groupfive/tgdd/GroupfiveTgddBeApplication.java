package vn.com.groupfive.tgdd;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;

import vn.com.groupfive.tgdd.payload.dto.request.DistrictRequest;
import vn.com.groupfive.tgdd.payload.dto.request.ProvinceRequest;
import vn.com.groupfive.tgdd.payload.dto.request.VietnamAddressRequest;
import vn.com.groupfive.tgdd.payload.dto.request.WardRequest;
import vn.com.groupfive.tgdd.payload.entities.District;
import vn.com.groupfive.tgdd.payload.entities.Province;

@SpringBootApplication
public class GroupfiveTgddBeApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(GroupfiveTgddBeApplication.class, args);
//		VietnamAddressRequest mobilePhone = new VietnamAddressRequest();    
//		Set<ProvinceRequest> provinces = new HashSet<>();
//		Set<DistrictRequest> districts = new HashSet<>();
//		Set<WardRequest> wards = new HashSet<>();
//		wards.add(new WardRequest("2", "test", "2"));
//		districts.add(new DistrictRequest("2", "test", wards));
//		provinces.add(new ProvinceRequest("2", "test", districts));
//		mobilePhone.setProvinces(provinces);
//        System.out.println("The JSON representation of Object mobilePhone is ");    
//        System.out.println(new Gson().toJson(mobilePhone));    
	}

}
