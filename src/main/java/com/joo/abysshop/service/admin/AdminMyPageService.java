package com.joo.abysshop.service.admin;

import com.joo.abysshop.dto.admin.AddProductRequest;
import com.joo.abysshop.entity.admin.AddProductEntity;
import com.joo.abysshop.entity.product.ProductImageEntity;
import com.joo.abysshop.enums.UserType;
import com.joo.abysshop.mapper.entity.ToProductEntityMapper;
import com.joo.abysshop.mapper.mybatis.AdminMapper;
import com.joo.abysshop.mapper.mybatis.ProductMapper;
import java.io.File;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AdminMyPageService {

    private final AdminMapper adminMapper;
    private final ToProductEntityMapper toProductEntityMapper;
    private final ProductMapper productMapper;

    public UserType getUserType(final Long userId) {
        return adminMapper.getUserType(userId);
    }

    public void addProduct(AddProductRequest addProductRequest) throws IOException {
        if (addProductRequest.getImage() == null || addProductRequest.getImage().isEmpty()) {
            AddProductEntity addProductEntity = toProductEntityMapper.toAddProductEntity(addProductRequest);
            adminMapper.insertProduct(addProductEntity);
        } else if (addProductRequest.getImage() != null) {
            //TODO: 이미지 관련 내용은 추후에 테스트하고 완성시키기
            //이미지를 C 드라이브 아래의 별도의 디렉토리에 저장
            MultipartFile imageFile = addProductRequest.getImage();
            String originalFileName = addProductRequest.getOriginalFileName();
            String savePath = "C:/abysshop_img/" + originalFileName;
            imageFile.transferTo(new File(savePath));

            //상품, 이미지 INSERT 작업
            AddProductEntity addProductEntity = toProductEntityMapper.toAddProductEntity(addProductRequest);
            adminMapper.insertProduct(addProductEntity);

            //TODO: product_name 필드를 중복이 없게 만들어주기
            Long productId = productMapper.findProductIdByProductName(addProductRequest.getProductName());
            ProductImageEntity productImageEntity = toProductEntityMapper.toProductImageEntity(
                addProductRequest, productId);
            adminMapper.insertProductImage(productImageEntity);
        }
    }

    public void removeProduct(Long productId) {
        //TODO: product_image_table에 ON DELETE CASCADE 속성 추가해서 이미지 삭제시키기
        adminMapper.deleteByProductId(productId);
    }
}