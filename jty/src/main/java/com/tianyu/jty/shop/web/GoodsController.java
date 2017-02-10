package com.tianyu.jty.shop.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyu.jty.common.persistence.Page;
import com.tianyu.jty.common.persistence.PropertyFilter;
import com.tianyu.jty.common.web.BaseController;
import com.tianyu.jty.shop.entity.Goods;
import com.tianyu.jty.shop.service.GoodsService;

/**
 * 商品controller
 * @author ty
 * @date 2015年1月22日
 */
@Controller
@RequestMapping("shop/goods")
public class GoodsController extends BaseController{
	
	@Autowired
	private GoodsService goodsService;

	/**
	 * 默认页面
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "shop/goodsList";
	}
	
	/**
	 * 获取商品json
	 */
	@RequestMapping(value="json",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> goodsList(HttpServletRequest request) {
		Page<Goods> page = getPage(request);
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(request);
		page = goodsService.search(page, filters);
		return getEasyUIData(page);
	}
	
	/**
	 * 添加商品跳转
	 * 
	 * @param model
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("goods", new Goods());
		model.addAttribute("action", "create");
		return "system/goodsForm";
	}

	/**
	 * 添加商品
	 * 
	 * @param goods
	 * @param model
	 */
	@RequestMapping(value = "create", method = RequestMethod.POST)
	@ResponseBody
	public String create(@Valid Goods goods, Model model) {
		goodsService.save(goods);
		return "success";
	}

	/**
	 * 修改商品跳转
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("goods", goodsService.get(id));
		model.addAttribute("action", "update");
		return "system/goodsForm";
	}

	/**
	 * 修改商品
	 * 
	 * @param goods
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public String update(@Valid @ModelAttribute @RequestBody Goods goods,Model model) {
		goodsService.update(goods);
		return "success";
	}

	/**
	 * 删除商品
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delete/{id}")
	@ResponseBody
	public String delete(@PathVariable("id") Integer id) {
		goodsService.delete(id);
		return "success";
	}
	
	@ModelAttribute
	public void getGoods(@RequestParam(value = "id", defaultValue = "-1") Integer id,Model model) {
		if (id != -1) {
			model.addAttribute("goods", goodsService.get(id));
		}
	}
}
