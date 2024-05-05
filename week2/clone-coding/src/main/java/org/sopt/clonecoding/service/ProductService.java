package org.sopt.clonecoding.service;

import lombok.RequiredArgsConstructor;
import org.sopt.clonecoding.domain.Member;
import org.sopt.clonecoding.domain.Product;
import org.sopt.clonecoding.repository.MemberRepository;
import org.sopt.clonecoding.repository.ProductRepository;
import org.sopt.clonecoding.web.dto.ProductCreateDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    @Transactional
    public String createProduct(ProductCreateDto productCreateDto){
        Member member = memberRepository.findById(productCreateDto.memberId())
                .orElseThrow(() -> new IllegalArgumentException("해당하는 Id가 존재하지 않습니다 memberId : " + productCreateDto.memberId()));
        Product product = Product.create(
                member,
                productCreateDto.title(),
                productCreateDto.isSale(),
                productCreateDto.price(),
                productCreateDto.description(),
                productCreateDto.address()
        );
        productRepository.save(product);
        return product.getId().toString();
    }
}
