package jp.co.internous.lion.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jp.co.internous.lion.model.domain.dto.CartDto;

@Mapper
public interface TblCartMapper {

	//UserIdでカート情報を検索
	public List<CartDto> findByUserId(@Param("userId") int userId);
	
	//UserIdと商品IDでカート情報を検索
	@Select("SELECT count(id) FROM tbl_cart WHERE user_id = #{userId} AND product_id = #{productId}")
	public int findByUserIdAndProductId(@Param("userId") int userId,
										 @Param("productId") int productId);
	
	//countの値を更新
	public void updateProductCount(@Param("userId") int userId,
									@Param("productId") int productId,
									@Param("productCount") int productCount);
	
	//新規カート情報を追加
	public void insert(@Param("userId") int userId,
						@Param("productId") int productId,
						@Param("productCount") int productCount);
	
	//カートIDによるカート情報の削除
	public int deleteByCartId(@Param("deleteCartId") String[] deleteCartId);
	
	
	//ユーザーIDによるカート情報の削除(決済機能で利用)
	@Delete("DELETE FROM tbl_cart WHERE user_id = #{userId}")
	public int deleteByUserId(@Param("userId") int userId);
	
	//仮ユーザーIDをユーザーIDに置き換える(ログイン認証機能で利用)
	@Update("UPDATE tbl_cart SET user_id = #{userId}, updated_at = now() WHERE user_id = #{temporaryUserId}")
	public void updateUserId(@Param("userId") int userId,
							  @Param("temporaryUserId") int temporaryUserId);
}
