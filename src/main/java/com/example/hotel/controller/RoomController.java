package com.example.hotel.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.Util.UploadUtil;
import com.example.hotel.entity.Room;
import com.example.hotel.response.Result;
import com.example.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping ("/room")
public class RoomController {
	@Autowired
	RoomService roomService;
	
	@GetMapping ("/cond")
	public Result getRoomByCond (@RequestParam (defaultValue = "-1") Integer current , @RequestParam (defaultValue = "-1") Integer size , Integer roomId , String roomTypeId , String roomTypeName , String status) {
		Page page = new Page<> (current , size);
		Page<Room> roomPage = roomService.getRoomByCond (page , roomId , roomTypeId , roomTypeName , status);
		return Result.ok ().data ("items" , roomPage);
	}
	
	@PostMapping ("/add")
	public Result addRoom (Room room , MultipartFile file) // MultipartFile实现文件上传
	{
		// 设置图片
		if (! Objects.isNull (file)) {
			String url = new UploadUtil ().uploadFile (file);
			room.setImage (url);
		}
		if (roomService.addRoom (room) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
	
	@PutMapping ("/update")
	public Result updateRoom (Room room , MultipartFile file) {
		// 设置头像
		if (! Objects.isNull (file)) {
			String url = new UploadUtil ().uploadFile (file);
			room.setImage (url);
			String oldFile = roomService.selectById (room.getRoomId ()).getImage ();
			UploadUtil.deleteFile (oldFile);
		}
		if (roomService.updateRoom (room) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
	
	@DeleteMapping ("/deleteMul")
	public Result deleteMulRoom (@RequestBody List<Integer> roomIds) {
		List<String> files = new ArrayList<> ();
		for (Integer id : roomIds) {
			files.add (roomService.selectById (id).getImage ());
		}
		roomService.delMulRoom (roomIds);
		for (String file : files) {
			UploadUtil.deleteFile (file);
		}
		return Result.ok ();
	}
}