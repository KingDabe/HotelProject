package com.boot.hotel.util;

import org.springframework.stereotype.Service;

@Service
public class MyUtil {

	
	public int getPageCount(int numPerPage, int dataCount) {
	
		int pageCount = 0;
		
		pageCount = dataCount / numPerPage;
		
		if(dataCount%numPerPage !=0) {
			pageCount++;
		}
		return pageCount;
			
	}
	
	
	public String pageIndexList(int currentPage, int totalPage, String listUrl) {
	    int numPerBlock = 5; // 한 블록당 페이지 수
	    int currentPageSetup;
	    int page;
	    StringBuffer sb = new StringBuffer();

	    if (currentPage == 0 || totalPage == 0) {
	        return "";
	    }

	    if (listUrl.indexOf("?") != -1) {
	        listUrl = listUrl + "&";
	    } else {
	        listUrl = listUrl + "?";
	    }

	    currentPageSetup = (currentPage / numPerBlock) * numPerBlock;

	    if (currentPage % numPerBlock == 0) {
	        currentPageSetup = currentPageSetup - numPerBlock;
	    }

	    if (totalPage > numPerBlock && currentPageSetup > 0) {
	        sb.append("<a href=\"" + listUrl + "pageNum=" + (currentPageSetup - numPerBlock + 1) + "\">이전</a>&nbsp;");
	    }

	    page = currentPageSetup + 1;

	    while (page <= totalPage && page <= (currentPageSetup + numPerBlock)) {
	        if (page == currentPage) {
	        	sb.append("<a href=\"" + listUrl + "pageNum=" + currentPage + "\">" + currentPage + "</a> ");
	        } else {
	        	
	            sb.append("<a href=\"" + listUrl + "pageNum=" + page + "\">" + page + "</a> ");
	        }
	        page++;
	    }

	    if (totalPage - currentPageSetup > numPerBlock) {
	        sb.append("<a href=\"" + listUrl + "pageNum=" + (currentPageSetup + numPerBlock + 1) + "\">다음</a>&nbsp;");
	    }

	    return sb.toString();
	}


	

	
}
