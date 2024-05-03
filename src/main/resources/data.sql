insert into teacher (teacher_code, teacher_name, class_name, class_price, teacher_gegist_date) values ('100', '이초급','초급반','100000','20220101');
insert into teacher (teacher_code, teacher_name, class_name, class_price, teacher_gegist_date) values ('200', '김중급','중급반','200000','20220102');
insert into teacher (teacher_code, teacher_name, class_name, class_price, teacher_gegist_date) values ('300', '박고급','고급반','300000','20220103');
insert into teacher (teacher_code, teacher_name, class_name, class_price, teacher_gegist_date) values ('400', '정심화','심화반','400000','20220104');

insert into member (member_id, member_name, phone, address, grade) values ('10001', '홍길동','01011112222','서울시 강남구','일반');
insert into member (member_id, member_name, phone, address, grade) values ('10002', '장발장','01022223333','성남시 분당구','일반');
insert into member (member_id, member_name, phone, address, grade) values ('10003', '임꺽정','01033334444','대전시 유성구','일반');
insert into member (member_id, member_name, phone, address, grade) values ('20001', '성춘향','01044445555','부산시 서구','VIP');
insert into member (member_id, member_name, phone, address, grade) values ('20002', '이몽룡','01055556666','대구시 북구','VIP');

insert into class (regist_month, class_no, class_area, tuition,teacher_code ) values ('202203', '10001','서울본원','100000','100');
insert into class (regist_month, class_no, class_area, tuition,teacher_code ) values ('202203', '10002','성남분원','100000','100');
insert into class (regist_month, class_no, class_area, tuition,teacher_code ) values ('202203', '10003','대전분원','200000','200');
insert into class (regist_month, class_no, class_area, tuition,teacher_code ) values ('202203', '20001','부산분원','150000','300');
insert into class (regist_month, class_no, class_area, tuition,teacher_code ) values ('202203', '20002','대구분원','200000','400');



