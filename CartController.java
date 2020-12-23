package jp.co.internous.lion.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.internous.lion.model.domain.dto.CartDto;
import jp.co.internous.lion.model.form.CartForm;
import jp.co.internous.lion.model.mapper.TblCartMapper;
import jp.co.internous.lion.model.session.LoginSession;

@Controller
@RequestMapping("/lion/cart")
public class CartController {

	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	TblCartMapper tblCartMapper;
	
	
	//「カート画面／初期表示」
	@RequestMapping("/")
	public String index(Model m) {
		
		//ユーザーID(未ログインの場合仮ユーザーID)を取得
		int userId = loginSession.getUserId();
		if(userId == 0) {
			userId = loginSession.getTemporaryUserId();
		}
		
		//ユーザーIDで検索しカート情報を抽出
		List<CartDto> cartList = tblCartMapper.findByUserId(userId);
		
		//結果をcart.htmlに渡す
		m.addAttribute("cartList", cartList);
		//LoginSessionの内容も必要なため、同時に渡す
		m.addAttribute("loginSession", loginSession);
		
		//cart.htmlを表示
		return "cart";
	}
	
	
	//カート機能「カート追加処理」
	@RequestMapping("/add")
	public String addCart(CartForm form) {
		
		//ユーザーIDを取得
		int userId = loginSession.getUserId();
		if(userId == 0) {
			userId = loginSession.getTemporaryUserId();
		}
		
		//ユーザーIDと商品IDでtbl_cartを検索(件数を取得)
		int cartCount = tblCartMapper.findByUserIdAndProductId(userId, form.getProductId());
		
		//データが存在しない場合、新たにデータを追加
		//存在する場合、個数を追加する形で更新
		if(cartCount == 0) {
			tblCartMapper.insert(userId, form.getProductId(), form.getProductCount());
		} else {
			tblCartMapper.updateProductCount(userId, form.getProductId(), form.getProductCount());
		}
		
		//「カート画面／初期表示」に移る
		return "forward:/lion/cart/";
	}
	
	//「カート画面／削除機能」
	@ResponseBody
	@RequestMapping("/delete")
	public boolean deleteCart(@RequestBody CartForm form) {
		
		//削除処理を実行
		int result = tblCartMapper.deleteByCartId(form.getDeleteCartId());
		
		return result > 0;
	}
}
