package com.example.ragulshop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ragulshop.Entity.Clothes;
import com.example.ragulshop.Service.ShopService;
import com.example.ragulshop.ShopDTO.ShopDTO;

@RestController
@RequestMapping("/shop")
public class ShopController {

	  @Autowired
	  private ShopService service;
  
	  @PostMapping("/create")
	  public String  createdata(@RequestBody Clothes c)
	  {
		  return service.CreateCloth(c);
	  }
	  @GetMapping("/getcloth{id}")
	  public ShopDTO getCloth(@PathVariable int id)
	  {
		  return service.getClothByid(id);
	  }
	  @GetMapping("/getmaxview")
	  public List<Clothes> getmaxview()
	  {
		  return service.getMaxViewCount();
	  }
	    @GetMapping("/deldata{id}")
	    public String delete(@PathVariable int id)
	    {
	        return service.deleteById(id);
	    }
	    @PostMapping("/update")
	    public String update(@RequestBody Clothes emp)
	    {
	        return service.updateData(emp);
	    } 
	  
  
}
