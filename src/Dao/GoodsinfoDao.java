package Dao;

import com.table.Goodsinfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodsinfoDao extends ParentDao{
    //数据表查询功能
    public List<Goodsinfo> findByGoodsinfo(Goodsinfo goodsinfo){
        Connection connection = null;
        PreparedStatement sta = null;
        ResultSet rs = null;
        List<Goodsinfo> list = new ArrayList<>();
        try {
            connection = super.getConnection();
            List<Object> goodsinfoList = new ArrayList<>();
            StringBuffer sql = new StringBuffer();
            sql.append(" select * from goodsinfo where 1=1 ");
            if(goodsinfo != null && !"".equals(goodsinfo)) {
                if(goodsinfo.getId() != null){
                    sql.append(" and id = ?");
                    goodsinfoList.add(goodsinfo.getId());
                }
                if (goodsinfo.getGoodsinfoName() != null) {
                    sql.append(" and goodsinfo_name = ?");
                    goodsinfoList.add(goodsinfo.getGoodsinfoName());
                }
                if (goodsinfo.getGoodsinfoPic() != null) {
                    sql.append(" and goodsinfo_pic = ?");
                    goodsinfoList.add(goodsinfo.getGoodsinfoPic());
                }
                if (goodsinfo.getGoodsinfoPrice() > 0) {
                    sql.append(" and goodsinfo_price = ?");
                    goodsinfoList.add(goodsinfo.getGoodsinfoPrice());
                }
                if (goodsinfo.getGoodsinfoDescription() != null) {
                    sql.append(" and goodsinfo_description = ?");
                    goodsinfoList.add(goodsinfo.getGoodsinfoDescription());
                }
                if (goodsinfo.getGoodsinfoStock() >0) {
                    sql.append(" and goodsinfo_stock = ?");
                    goodsinfoList.add(goodsinfo.getGoodsinfoStock());
                }
            }
            sta = connection.prepareStatement(sql.toString());
            if(goodsinfoList != null && goodsinfoList.size() > 0){
                for(int i = 0 ; i < goodsinfoList.size() ; i++){
                    sta.setObject(i+1,goodsinfoList.get(i));
                }
            }
            rs = sta.executeQuery();
            while(rs.next()){
                Goodsinfo entity = new Goodsinfo();
                entity.setId(rs.getString("id"));
                entity.setGoodsinfoName(rs.getString("goodsinfo_name"));
                entity.setGoodsinfoPic(rs.getString("goodsinfo_pic"));
                entity.setGoodsinfoPrice(Double.parseDouble(rs.getString("goodsinfo_price")));
                entity.setGoodsinfoDescription(rs.getString("goodsinfo_description"));
                entity.setGoodsinfoStock(Integer.parseInt(rs.getString("goodsinfo_stock")));
                list.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.closeAll(connection,sta,rs);
        }
        return list;
    }
    //增加功能
    public int goodsinfoInsert(Goodsinfo goodsinfo){
        Connection connection = null;
        PreparedStatement sta = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            connection = super.getConnection();
            String sql = "insert into goodsinfo(goodsinfo_name, goodsinfo_pic , goodsinfo_price ," +
                    "goodsinfo_description , goodsinfo_stock) values(?,?,?,?,?)";
            sta = connection.prepareStatement(sql);
            sta.setString(1,goodsinfo.getGoodsinfoName());
            sta.setString(2,goodsinfo.getGoodsinfoPic());
            sta.setDouble(3,goodsinfo.getGoodsinfoPrice());
            sta.setString(4,goodsinfo.getGoodsinfoDescription());
            sta.setInt(5,goodsinfo.getGoodsinfoStock());
            rows = sta.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.closeAll(connection,sta,rs);
        }
        return rows;
    }

    //修改功能
    public int goodsinfoUpdate(Goodsinfo goodsinfo){
        Connection connection = null;
        PreparedStatement sta = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            connection = super.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("update goodsinfo set ");
            sql.append(" goodsinfo_name = ?");
            sql.append(" ,goodsinfo_pic = ?");
            sql.append(" ,goodsinfo_price = ?");
            sql.append(" ,goodsinfo_description = ?");
            sql.append(" ,goodsinfo_stock = ?");
            sql.append(" where id = ?");
            List<Object> goodsinfoList = new ArrayList<>();
            goodsinfoList.add(goodsinfo.getGoodsinfoName());
            goodsinfoList.add(goodsinfo.getGoodsinfoPic());
            goodsinfoList.add(goodsinfo.getGoodsinfoPrice());
            goodsinfoList.add(goodsinfo.getGoodsinfoDescription());
            goodsinfoList.add(goodsinfo.getGoodsinfoStock());
            goodsinfoList.add(goodsinfo.getId());
            sta = connection.prepareStatement(sql.toString());
            if(goodsinfoList != null && goodsinfoList.size() > 0){
                for(int i = 0 ; i < goodsinfoList.size() ; i++){
                    sta.setObject(i+1,goodsinfoList.get(i));
                }
            }
            rows = sta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.closeAll(connection,sta,rs);
        }
        return  rows;
    }

    public int goodsinfoDelete(Goodsinfo goodsinfo){
        Connection connection = null;
        PreparedStatement sta = null;
        ResultSet rs = null;
        try {
            connection = super.getConnection();
            String sql = "delete from goodsinfo where id = ?";
            sta = connection.prepareStatement(sql);
            sta.setString(1,goodsinfo.getId());
            int rows = sta.executeUpdate();
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.closeAll(connection,sta,rs);
        }
        return 0;
    }
}
