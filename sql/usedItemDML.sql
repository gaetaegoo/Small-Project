-- useditem insert[���� ���� ����]
insert into useditem values('�ڵ���', '������12', '700,000', '��', '��, ����ǰ, �� �� 6����', '�Ǹ���');
insert into useditem values('�Һ�', '�����Һ�', '10,000', '��', '��Ÿ����, �ʷϻ�, ����ǰ', '������');
insert into useditem values('����', 'īī������', '20,000', '��', '���̾�, ������, 2���� ��', '�ǸſϷ�');

-- seller insert[�Ǹ��� ����]
insert into seller values('seller1', '�̰ǿ�', '010-111-1111', '����', '����', '�ڵ���', '���ŷ�');
insert into seller values('seller2', '��ġ��', '010-222-2222', '��õ', '���', '�Һ�', '�ù�');
insert into seller values('seller3', '������', '010-333-3333', '���', '����', '����', '�ù�');

-- buyer insert[������ ����]
insert into buyer values('buyer1', '�����', '010-444-4444', '�λ�', '���', '�ڵ���', '�ù�');
insert into buyer values('buyer2', '������', '010-555-5555', '����', '����', '�Һ�', '���ŷ�');
insert into buyer values('buyer3', '������', '010-666-6666', '�뱸', '����', '����', '�ù�');

-- useditem_upload insert[���� ���ε� ����]
insert into useditem_upload values(useditem_upload_id_seq.nextval, '������12', '�ڵ���', 'seller1', 'buyer1');
insert into useditem_upload values(useditem_upload_id_seq.nextval, '�����Һ�', '�Һ�', 'seller2', 'buyer2');
insert into useditem_upload values(useditem_upload_id_seq.nextval, 'īī������', '����', 'seller3', 'buyer3');

commit;
