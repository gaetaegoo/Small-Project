-- useditem insert[물건 정보 저장]
insert into useditem values('핸드폰', '아이폰12', '700,000', '상', '블랙, 새상품, 산 지 6개월', '판매중');
insert into useditem values('텀블러', '스벅텀블러', '10,000', '중', '스타벅스, 초록색, 새상품', '예약중');
insert into useditem values('인형', '카카오인형', '20,000', '상', '라이언, 한정판, 2개월 됨', '판매완료');

-- seller insert[판매자 저장]
insert into seller values('seller1', '이건우', '010-111-1111', '서울', '열심', '핸드폰', '직거래');
insert into seller values('seller2', '정치즈', '010-222-2222', '인천', '우수', '텀블러', '택배');
insert into seller values('seller3', '마슈슈', '010-333-3333', '경기', '신입', '인형', '택배');

-- buyer insert[구매자 저장]
insert into buyer values('buyer1', '오대식', '010-444-4444', '부산', '우수', '핸드폰', '택배');
insert into buyer values('buyer2', '정마담', '010-555-5555', '서울', '신입', '텀블러', '직거래');
insert into buyer values('buyer3', '곽두팔', '010-666-6666', '대구', '열심', '인형', '택배');

-- useditem_upload insert[물건 업로드 저장]
insert into useditem_upload values(useditem_upload_id_seq.nextval, '아이폰12', '핸드폰', 'seller1', 'buyer1');
insert into useditem_upload values(useditem_upload_id_seq.nextval, '스벅텀블러', '텀블러', 'seller2', 'buyer2');
insert into useditem_upload values(useditem_upload_id_seq.nextval, '카카오인형', '인형', 'seller3', 'buyer3');

commit;
