package com.joo.abysshop.service.admin;

import com.joo.abysshop.dto.admin.AddProductRequest;
import com.joo.abysshop.entity.admin.AddProductEntity;
import com.joo.abysshop.entity.product.ProductImageEntity;
import com.joo.abysshop.enums.UserType;
import com.joo.abysshop.mapper.entity.ToProductEntityMapper;
import com.joo.abysshop.mapper.mybatis.AdminMapper;
import com.joo.abysshop.mapper.mybatis.ProductMapper;
import com.joo.abysshop.service.user.UserService;
import java.io.File;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AdminMyPageService {

    private final AdminMapper adminMapper;
    private final ProductMapper productMapper;
    private final ToProductEntityMapper toProductEntityMapper;
    private final UserService userService;

    public UserType getUserType(final Long userId) {
        return userService.getUserType(userId);
    }

    public void addProduct(AddProductRequest addProductRequest) throws IOException {
        if (addProductRequest.getImage() == null || addProductRequest.getImage().isEmpty()) {
            AddProductEntity addProductEntity = toProductEntityMapper.toAddProductEntity(addProductRequest);
            adminMapper.insertProduct(addProductEntity);
        } else if (addProductRequest.getImage() != null) {
            //이미지를 C 드라이브 아래의 별도의 디렉토리에 저장
            MultipartFile imageFile = addProductRequest.getImage();
            String originalFileName = addProductRequest.getOriginalFileName();
            String savePath = "C:/abysshop_img/" + originalFileName;
            imageFile.transferTo(new File(savePath));

            //상품, 이미지 INSERT 작업
            AddProductEntity addProductEntity = toProductEntityMapper.toAddProductEntity(addProductRequest);
            adminMapper.insertProduct(addProductEntity);

            Long productId = productMapper.findProductIdByProductName(addProductRequest.getProductName());
            ProductImageEntity productImageEntity = toProductEntityMapper.toProductImageEntity(
                addProductRequest, productId);
            adminMapper.insertProductImage(productImageEntity);
        }
    }

    public void removeProduct(Long productId) {
        adminMapper.deleteByProductId(productId);
    }
}