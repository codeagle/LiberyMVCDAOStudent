package dao;

import java.util.ArrayList;

import vo.ReaderType;

public interface ReaderTypeDAO {
	//��ѯȫ����������
	public ArrayList findAllReaderType(ReaderType readertype)throws Exception;
	//��Ӷ�������
	public boolean doCreate(ReaderType readertype)throws Exception;
	//�޸Ķ�������
	public boolean doUpdate(ReaderType readertype)throws Exception;
	//ɾ����������
	public boolean doDelete(int rtypeid)throws Exception;
	//����ָ��rtypeid��ѯ��������
	public ReaderType findReaderTypeById(int rtypeid)throws Exception;
}
