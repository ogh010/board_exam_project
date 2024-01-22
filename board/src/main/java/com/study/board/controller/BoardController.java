package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") // localhost:8080/board/wirte
    public String boardWriteForm() {
        return "boardwirte";
    }


    @PostMapping("/board/writepro")
    public String boardWritePro(Board board){
        System.out.println("title : "+board.getTitle());
        System.out.println("content : "+board.getContent());

        boardService.wirte(board);

        return "";
    }

    @GetMapping("/board/list")
    public String boardList(Model model){
        model.addAttribute("list",boardService.boardList());
        // "list"라는 이름으로 boardService.boardList() 값이 반환된다.
        return "boardlist";
    }

    @GetMapping("/board/view")
    public String boardView(){
        return "boardview";
    }

}
