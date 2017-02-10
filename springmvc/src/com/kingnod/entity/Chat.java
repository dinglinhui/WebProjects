package com.kingnod.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="jcn_chat")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Chat extends CommenEntity {
	
	private static final long serialVersionUID = 1134345L;
	/**
	 * 聊天方式
	 */
	@Enumerated(EnumType.STRING)
	@Column(name="chatType")
	private ChatType  chatType;
	
	/**
	 * 发言人ID
	 */
	private Long sendId;
	/**
	 * 接收对象ID （如房间ID，或者个人用户ID）
	 */
	private Long receiveId;
	/**
	 * 发送的消息内容
	 */
	@Column(name="content",length=300)
	private String content;
	/**
	 * 发送时间
	 */
	@Column(name="send_date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date sendDate;
	
	/**
	 * 已读标识  默认未读状态  已经被读：Y 未读:N
	 */
	@Column(name="read_flag",length=1)
	private String readFlag;
	
	public enum ChatType{
		allTOall("主屏式"),oneTOhome("房间式"),oneTOone("单聊式");
		private final String typeName;
		ChatType(final String typeName){
			this.typeName=typeName;
		}
		public String getTypeName(){
			return typeName;
		}
	}

	public ChatType getChatType() {
		return chatType;
	}

	public void setChatType(ChatType chatType) {
		this.chatType = chatType;
	}

	public Long getSendId() {
		return sendId;
	}

	public void setSendId(Long sendId) {
		this.sendId = sendId;
	}

	public Long getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(Long receiveId) {
		this.receiveId = receiveId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public String getReadFlag() {
		return readFlag;
	}

	public void setReadFlag(String readFlag) {
		this.readFlag = readFlag;
	}
}
