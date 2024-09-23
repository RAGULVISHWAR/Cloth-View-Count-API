package com.example.ragulshop.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.ragulshop.Entity.Clothes;
import com.example.ragulshop.Repository.ShopRepo;
import com.example.ragulshop.ShopDTO.ShopDTO;


@Service
public class ShopService {
	@Autowired
	private ShopRepo repo;
	

	public String CreateCloth(Clothes c) {
		// TODO Auto-generated method stub
		repo.save(c);
		return "created";
	}

	public ShopDTO getClothByid(int id) {
		// TODO Auto-generated method stub
		Optional<Clothes> c =repo.findById(id);
		if(c.isPresent())
		{
			addview(id);
			return new ShopDTO(c.get().getName(),c.get().getPrice());
		}
		return null;
	}
	@Transactional
	public void addview(int id)
	{
		Optional<Clothes> c1 =repo.findById(id);
		if(c1.isPresent())
		{
		 Clothes c=c1.get();
		 int v=c.getCount();
		 v+=1;
		 repo.updateview(v,id);
		}
	}
	public List<Clothes> getMaxViewCount()
	{
		return repo.Maxviewcount();
	}
	
	  public String deleteById(int id) {
	        Optional<Clothes> emp=repo.findById(id);
	        if(emp.isPresent()) {
	            repo.deleteById(id);
	            return "deleted";
	        }
	        return null;
	    }
	    public String updateData(Clothes cloth) {
	        Optional<Clothes> c=repo.findById(cloth.getId());
	        if(c.isPresent()) {
	            c.get().setName(cloth.getName() == null?c.get().getName():cloth.getName());
	            c.get().setPrice(cloth.getPrice()== null?c.get().getPrice():cloth.getPrice());
	            repo.save(c.get());
	            return "updated";
	        }
	        return null;
	    }

		

}
