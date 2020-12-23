package jp.co.internous.lion.model.form;

import java.io.Serializable;

public class CartForm implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/* カート追加処理に使用 */
	/* 商品ID */
	private int productId;
	/* 個数 */
	private int productCount;
	
	/* 削除する商品IDリスト(削除処理に使用) */
	private String[] deleteCartId;
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	
	public String[] getDeleteCartId() {
		return deleteCartId;
	}
	public void setDeleteCartId(String[] deleteCartId) {
		this.deleteCartId = deleteCartId;
	}
}
