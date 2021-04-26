package com.webank.wedatasphere.streamis.project.server.service.impl;


import com.webank.wedatasphere.streamis.project.common.CreateStreamProjectRequest;
import com.webank.wedatasphere.streamis.project.common.DeleteStreamProjectRequest;
import com.webank.wedatasphere.streamis.project.common.UpdateStreamProjectRequest;
import com.webank.wedatasphere.streamis.project.server.dao.ProjectMapper;
import com.webank.wedatasphere.streamis.project.server.entity.StreamisProject;
import com.webank.wedatasphere.streamis.project.server.entity.request.CreateProjectRequest;
import com.webank.wedatasphere.streamis.project.server.exception.StreamisProjectErrorException;
import com.webank.wedatasphere.streamis.project.server.service.ProjectService;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * created by yangzhiyue on 2021/4/19
 * Description:
 */
@Service
public class ProjectServiceImpl implements ProjectService {





    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Autowired
    private ProjectMapper projectMapper;


    @Override
    public StreamisProject createProject(String username, CreateProjectRequest createProjectRequest) throws StreamisProjectErrorException {
        LOGGER.info("user {} starts to create project {}", username, createProjectRequest.getProjectName());
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public StreamisProject createProject(CreateStreamProjectRequest createStreamProjectRequest) throws StreamisProjectErrorException {
        LOGGER.info("user {} starts to create project {}", createStreamProjectRequest.createBy(), createStreamProjectRequest.projectName());
        StreamisProject streamisProject = new StreamisProject(createStreamProjectRequest.projectName(), createStreamProjectRequest.description(), createStreamProjectRequest.createBy());
        projectMapper.insertProject(streamisProject);
        LOGGER.info("user {} ends to create project {} and id is {}", createStreamProjectRequest.createBy(), createStreamProjectRequest.projectName(), streamisProject.getId());
        return streamisProject;
    }

    @Override
    public void updateProject(UpdateStreamProjectRequest updateStreamProjectRequest) throws StreamisProjectErrorException {
        LOGGER.info("User {} begins to update project {}", updateStreamProjectRequest.updateBy(), updateStreamProjectRequest.projectName());

    }


    @Override
    public void deleteProject(DeleteStreamProjectRequest deleteStreamProjectRequest) throws StreamisProjectErrorException {

    }
}
