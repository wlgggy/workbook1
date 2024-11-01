package kr.hs.sdh.workbook1.repository;

import kr.hs.sdh.workbook1.entity.Hamburger;

import java.util.Set;

public interface HamburgerRepository {

    // 햄버거 데이터 전체 조회
    Set<Hamburger> findHamburgers();

    void deleteHamburger(Hamburger hamburger);

    Hamburger saveHamburger(Hamburger hamburger);
}