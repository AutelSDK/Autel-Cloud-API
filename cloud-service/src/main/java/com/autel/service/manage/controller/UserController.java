package com.autel.service.manage.controller;

import com.autel.great.context.response.HttpResultResponse;
import com.autel.great.context.page.PaginationData;
import com.autel.great.context.model.CustomClaim;
import com.autel.great.context.web.core.AuthInterceptor;
import com.autel.service.manage.model.dto.UserListDTO;
import com.autel.service.manage.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("${url.manage.prefix}${url.manage.version}/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/current")
    public HttpResultResponse getCurrentUserInfo(HttpServletRequest request) {
        CustomClaim customClaim = (CustomClaim)request.getAttribute(AuthInterceptor.TOKEN_CLAIM);
        return userService.getUserByUsername(customClaim.getUsername(), customClaim.getWorkspaceId());
    }

    @GetMapping("/{workspace_id}/users")
    public HttpResultResponse<PaginationData<UserListDTO>> getUsers(@RequestParam(defaultValue = "1") Long page,
                                                                    @RequestParam(value = "page_size", defaultValue = "50") Long pageSize,
                                                                    @PathVariable("workspace_id") String workspaceId) {
        PaginationData<UserListDTO> paginationData = userService.getUsersByWorkspaceId(page, pageSize, workspaceId);
        return HttpResultResponse.success(paginationData);
    }
    @PutMapping("/{workspace_id}/users/{user_id}")
    public HttpResultResponse updateUser(@RequestBody UserListDTO user,
                                         @PathVariable("workspace_id") String workspaceId,
                                         @PathVariable("user_id") String userId) {

        userService.updateUser(workspaceId, userId, user);
        return HttpResultResponse.success();
    }
}
