package com.joo.abysshop.service.admin;

import com.joo.abysshop.dto.admin.AddProductRequest;
import com.joo.abysshop.dto.product.ProductListResponse;
import com.joo.abysshop.entity.admin.AddProductEntity;
import com.joo.abysshop.entity.admin.AddProductImageEntity;
import com.joo.abysshop.entity.product.ProductEntity;
import com.joo.abysshop.enums.UserType;
import com.joo.abysshop.mapper.dto.ToProductDTOMapper;
import com.joo.abysshop.mapper.entity.ToProductEntityMapper;
import com.joo.abysshop.mapper.mybatis.AdminMapper;
import com.joo.abysshop.mapper.mybatis.ProductMapper;
import com.joo.abysshop.service.user.UserService;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AdminMyPageService {

    private final AdminMapper adminMapper;
    private final ProductMapper productMapper;
    private final ToProductDTOMapper toProductDTOMapper;
    private final ToProductEntityMapper toProductEntityMapper;
    private final UserService userService;
    private final SqlSession sqlSession;

    public UserType getUserType(final Long userId) {
        return userService.getUserType(userId);
    }

    public List<ProductListResponse> getAllProducts() {
        List<ProductEntity> productEntityList = productMapper.findAllProducts();
        List<ProductListResponse> productList = new ArrayList<>();

        for (ProductEntity productEntity : productEntityList) {
            productList.add(toProductDTOMapper.toProductListResponse(productEntity));
        }

        return productList;
    }

    public void addProduct(AddProductRequest addProductRequest) throws IOException {
        //if (addProductRequest.getImage() == null || addProductRequest.getImage().isEmpty()) {
        //    AddProductEntity addProductEntity = toProductEntityMapper.toAddProductEntity(
       //         addProductRequest);
        //    adminMapper.insertProduct(addProductEntity);
        //} else if (addProductRequest.getImage() != null) {
            //이미지를 C 드라이브 아래의 별도의 디렉토리에 저장
            MultipartFile imageFile = addProductRequest.getImage();
            String originalFileName = imageFile.getOriginalFilename();
            String savePath = "C:/abysshop_img/" + originalFileName;
            imageFile.transferTo(new File(savePath));

            //상품 INSERT 작업
            AddProductEntity addProductEntity = toProductEntityMapper.toAddProductEntity(
                addProductRequest);
            adminMapper.insertProduct(addProductEntity);
            Long productId = addProductEntity.getProductId();

            //TODO: jsp 수정해서 이미지 제대로 불러오기
            
            //상품 이미지 INSERT 작업
        //String productName = addProductRequest.getProductName();
            //Long productId = productMapper.findProductIdByProductName(productName);
            AddProductImageEntity addProductImageEntity = toProductEntityMapper.toAddProductImageEntity(originalFileName, productId);
            adminMapper.insertProductImage(addProductImageEntity);
        //}
    }

    public void removeProduct(Long productId) {
        adminMapper.deleteByProductId(productId);
    }
}