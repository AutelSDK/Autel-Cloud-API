package com.autel.service.media.controller;

import com.autel.great.context.response.HttpResultResponse;
import com.autel.great.context.page.PaginationData;
import com.autel.service.media.model.MediaFileDTO;
import com.autel.service.media.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

@RestController
@RequestMapping("${url.media.prefix}${url.media.version}/files")
public class FileController {

    @Autowired
    private IFileService fileService;

    @GetMapping("/{workspace_id}/files")
    public HttpResultResponse<PaginationData<MediaFileDTO>> getFilesList(@RequestParam(defaultValue = "1") Long page,
                                                                         @RequestParam(name = "page_size", defaultValue = "10") Long pageSize,
                                                                         @PathVariable(name = "workspace_id") String workspaceId) {
        PaginationData<MediaFileDTO> filesList = fileService.getMediaFilesPaginationByWorkspaceId(workspaceId, page, pageSize);
        return HttpResultResponse.success(filesList);
    }

    @GetMapping("/{workspace_id}/file/{file_id}/url")
    public void getFileUrl(@PathVariable(name = "workspace_id") String workspaceId,
                           @PathVariable(name = "file_id") String fileId, HttpServletResponse response) {

        try {
            URL url = fileService.getObjectUrl(workspaceId, fileId);
            response.sendRedirect(url.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
