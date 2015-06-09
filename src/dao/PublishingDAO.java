package dao;

import java.util.ArrayList;

import vo.Publishing;

public interface PublishingDAO {
	//��ѯȫ���������
	public ArrayList findAllPublishing(Publishing publishing)throws Exception;
	//��������Ϣ
	public boolean doCreate(Publishing publishing)throws Exception;
	//�޸������Ϣ
	public boolean doUpdate(Publishing publishing)throws Exception;
	//ɾ�����������Ϣ
	public boolean doDelete(int pubid)throws Exception;
	//����ָ��caseid��ѯ�����Ϣ
	public Publishing findPublishingById(int pubid)throws Exception;
}
