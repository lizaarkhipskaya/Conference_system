<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<fmt:setBundle basename="page_content"/>
<fmt:setLocale value="${locale}" scope="session" />

<div class="col-md-6">
    <form class="form">
        <h1>Добавить речь</h1>
         <div class="form-group">
            <div class="col-md-12">
                <div class="form-group">
                    <input type="text" class="form-control" name="name" placeholder="Название речи"/>
                </div>
            </div>
            <div class="col-md-12">
                <label for="exampleFormControlSelect1">Выберите конференцию</label>
                <select class="form-control" id="exampleFormControlSelect1">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
            </div>
            <div class="col-md-12">
                <label for="exampleFormControlSelect1">Выберите время</label>
                <select class="form-control" id="exampleFormControlSelect1">
                    <option>1</option>
                    <option>2</option>
                    <option>4</option>
                    <option>3</option>
                    <option>5</option>
                </select>
            </div>
        </div>
    </form>
</div>
<div class="col-md-6">
    <h1>Личная информация</h1>
    <div class="col-md-10">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <div class="container bootstrap snippet">
            <div class="content-hero">
              <img class="content-hero-embed" src="https://lorempixel.com/250/250/nature/8/" alt="cover">
              <div class="content-hero-overlay bg-grd-red"></div>
              <div class="content-hero-body">
                <div class="pull-right" role="group">
                  <a  class="btn btn-icon btn-default"><span class="fa fa-user"></span></a>
                </div>
              </div>
            </div>

            <div class="content-hero content-hero-sm">
              <div class="row">
                <div class="col-md-6 col-xs-8">
                  <div class="media">
                    <div class="media-left">
                      <a class="kit-avatar kit-avatar-64 no-padding border-white hidden-xs" href="#">
                        <img alt="cover" src="https://bootdey.com/img/Content/avatar/avatar1.png">
                      </a>
                      <a class="kit-avatar kit-avatar-42 no-padding border-white visible-xs" href="#">
                        <img alt="cover" src="https://bootdey.com/img/Content/avatar/avatar1.png">
                      </a>
                    </div>
                    <div class="media-body">
                      <h2 class="display-name media-heading text-red hidden-xs">Angela Fowler</h2>
                      <h3 class="display-name media-heading text-red visible-xs">Angela Fowler</h3>
                      <p class="text-muted"><span class="mr-2x">Since April 21, 2010</span> <span><i class="fa fa-skype fa-fw hidden-xs"></i> (+44) 212 008 5656</span></p>
                    </div><!-- /.pull -->
                  </div>
                </div><!-- /.cols -->

                <div class="col-md-2 col-xs-4 col-md-push-4 text-right">
                  <a href="#" rel="button" class="btn btn-default" data-toggle="tooltip" data-placement="left" title="" aria-label="Poke" data-original-title="Jawil sitik"><i class="fa fa-thumbs-o-up"></i></a>
                  <a href="#" rel="button" class="btn btn-default" data-toggle="tooltip" data-placement="left" title="" aria-label="Send a Messege" data-original-title="Send a Messege"><i class="fa fa-envelope-o"></i></a>
                </div><!-- /.cols -->

                <div class="col-md-4 col-xs-12 col-md-pull-2 text-center">
                  <div class="row">
                    <div class="col-xs-4">
                      <div class="p-1x">
                        <span class="headline"><strong>1,5K</strong></span>
                        <p>Activities</p>
                      </div>
                    </div><!-- /.cols -->
                    <div class="col-xs-4">
                      <div class="p-1x">
                        <span class="headline"><strong>23</strong></span>
                        <p>Events</p>
                      </div>
                    </div><!-- /.cols -->
                    <div class="col-xs-4">
                      <div class="p-1x">
                        <span class="headline"><strong>2,4K</strong></span>
                        <p>Followers</p>
                      </div>
                    </div><!-- /.cols -->
                  </div><!-- /.row -->
                </div><!-- /.cols -->
              </div><!-- /.row -->
            </div>
            <div class="content-body">
                <ul class="timeline">
                    <li class="timeline-line"></li>
                    <li class="timeline-group">
                      <a href="#" class="btn btn-default">Today</a>
                    </li>
                </ul>
                <ul class="timeline">
                    <li class="timeline-line" style="height:600px;"></li>
                    <li class="timeline-item timeline-poster">
                      <div class="timeline-badge">
                        <a class="border-teal" rel="tooltip" title="" data-container="body" href="#" data-original-title="What will you do?"></a>
                      </div>
                      <div class="timeline-panel panel fade in panel-default panel-fill" data-fill-color="true" data-init-panel="true">
                        <div class="panel-body">
                          <ul class="nav nav-tabs nav-contrast-red">
                            <li class=""><a data-toggle="tab" href="#" aria-expanded="false">Status</a></li>
                            <li class=""><a data-toggle="tab" href="#" aria-expanded="false">Photo</a></li>
                            <li class=""><a data-toggle="tab" href="#" aria-expanded="false">Place</a></li>
                            <li class="active"><a data-toggle="tab" href="#" aria-expanded="true">Events</a></li>
                          </ul>
                          <div class="tab-content pt-1x">
                            <textarea name="timelinePost" rows="6" class="form-control autogrow no-border no-resize" placeholder="Write in timeline" style="overflow: hidden; min-height: 6em; height: 52px;"></textarea><div class="autogrow-textarea-mirror" style="display: none; word-wrap: break-word; white-space: normal; padding: 6px 12px; width: 461px; font-family: 'Open Sans', 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 20px;">.<br>.</div>
                          </div>
                        </div><!-- /.panel-body -->
                        <div class="panel-footer">
                          <div class="btn-group">
                            <button type="button" class="btn btn-link"><i class="fa fa-user"></i></button>
                            <button type="button" class="btn btn-link"><i class="fa fa-map-marker"></i></button>
                            <button type="button" class="btn btn-link"><i class="fa fa-camera"></i></button>
                            <button type="button" class="btn btn-link"><i class="fa fa-smile-o"></i></button>
                          </div>
                          <div class="pull-right">
                            <button type="submit" class="btn btn-success">Post</button>
                          </div>
                        </div><!-- /.panel-footer -->
                      </div><!-- /.timeline-panel.panel -->
                    </li>

                    <li class="timeline-item">
                      <div class="timeline-badge">
                        <a class="border-orange" rel="tooltip" title="" data-container="body" href="#" data-original-title="Post"></a>
                      </div>
                      <div class="timeline-panel panel fade in panel-default panel-fill" data-fill-color="true" data-init-panel="true">
                        <div class="panel-body">
                          <div class="media mb-2x">
                            <div class="media-left">
                              <a href="#" class="timeline-avatar kit-avatar kit-avatar-36">
                                <img class="media-object" src="https://bootdey.com/img/Content/avatar/avatar2.png" alt="">
                              </a>
                            </div><!-- /.media-left -->
                            <div class="media-body">
                              <p class="media-heading"><strong>Angela Fowler</strong> <br><small class="text-muted">30 minutes</small></p>
                            </div><!-- /.media-body -->
                          </div><!-- /.media -->

                          <p>Assumenda, pariatur repellendus voluptatum eaque sint, quibusdam voluptatem nulla nesciunt placeat sunt tempore ad reiciendis ducimus dicta neque minima debitis delectus ab!</p>
                        </div><!-- /.panel-body -->

                        <div class="panel-body timeline-resume">
                          <div class="pull-right" data-toggle="tooltip" title="" data-original-title="in this post">
                            <a class="kit-avatar kit-avatar-24 align-middle no-border" href="#">
                              <img alt="avatar" title="friend name" src="https://bootdey.com/img/Content/avatar/avatar3.png">
                            </a>
                            <a class="kit-avatar kit-avatar-24 align-middle no-border" href="#">
                              <img alt="avatar" title="friend name" src="https://bootdey.com/img/Content/avatar/avatar4.png">
                            </a>
                            <a class="kit-avatar kit-avatar-24 align-middle no-border" href="#">
                              <img alt="avatar" title="friend name" src="https://bootdey.com/img/Content/avatar/avatar5.png">
                            </a>
                            <a href="#" class="btn btn-xs btn-default btn-circle">+4</a>
                          </div>
                          <a href="#" class="btn btn-bordered btn-default btn-sm">+33</a>
                          <a href="#" class="btn btn-bordered btn-default btn-sm"><span class="fa fa-share fa-fw"></span> 7</a>
                        </div><!-- /.panel-body -->

                        <div class="panel-body timeline-livelines">
                          <p><a href="#"><small><i class="fa fa-comment-o fa-fw"></i> View 4 more comments</small></a></p>
                          <div class="media">
                            <div class="media-left">
                              <a class="kit-avatar kit-avatar-28" href="#">
                                <img class="media-object" src="https://bootdey.com/img/Content/avatar/avatar6.png">
                              </a>
                            </div>
                            <div class="media-body bordered-bottom">
                              <p class="media-heading"><strong>Arina Rosetti</strong> Consequuntur illo accusantium, expedita ratione dolorem fuga minima!</p>
                              <p class="text-muted"><small>22 minutes</small> </p>
                            </div>
                          </div><!-- /.media -->
                          <div class="media">
                            <div class="media-left">
                              <a class="kit-avatar kit-avatar-28" href="#">
                                <img class="media-object" src="https://bootdey.com/img/Content/avatar/avatar1.png">
                              </a>
                            </div>
                            <div class="media-body bordered-bottom">
                              <p class="media-heading"><strong>Júlia Ribeiro</strong> Veritatis aspernatur totam illum quisquam ipsa accusantium, animi voluptatum rem placeat.</p>
                              <p class="text-muted"><small>18 minutes</small> </p>
                            </div>
                          </div><!-- /.media -->
                          <div class="media">
                            <div class="media-left">
                              <a class="kit-avatar kit-avatar-28" href="#">
                                <img class="media-object" src="https://bootdey.com/img/Content/avatar/avatar2.png">
                              </a>
                            </div>
                            <div class="media-body">
                              <p class="media-heading"><strong>Felix Koller</strong> Molestias ipsum hic voluptas soluta expedita, ab, dolorum aperiam neque nesciunt.</p>
                              <p class="text-muted"><small>10 minutes</small> </p>
                            </div>
                          </div><!-- /.media -->
                        </div><!-- /.panel-body -->

                        <div class="panel-footer timeline-livelines">
                          <form action="#">
                            <a class="kit-avatar kit-avatar-28 no-border pull-left" href="#">
                              <img class="media-object" src="https://bootdey.com/img/Content/avatar/avatar3.png">
                            </a>
                            <div class="input-group input-group-in no-border">
                              <input class="form-control" placeholder="write comment...">
                              <div class="input-group-btn">
                                <button type="submit" class="btn"><i class="fa fa-chevron-circle-right"></i></button>
                              </div>
                            </div>
                          </form>
                        </div><!-- /.panel-footer -->
                      </div><!-- /.timeline-panel.panel -->
                    </li>
                    <li class="timeline-item">
                      <div class="timeline-badge">
                        <a class="border-red" rel="tooltip" title="" data-container="body" href="#" data-original-title="photo"></a>
                      </div>
                      <div class="timeline-panel panel fade in panel-default panel-fill" data-fill-color="true" data-init-panel="true">
                        <div class="panel-body">
                          <div class="media mb-1x">
                            <div class="media-left">
                              <a href="#" class="timeline-avatar kit-avatar kit-avatar-36">
                                <img src="https://bootdey.com/img/Content/avatar/avatar4.png" alt="">
                              </a>
                            </div>
                            <div class="media-body">
                              <div class="timeline-actions pull-right">
                                <div class="dropdown">
                                  <a href="#" class="btn btn-icon btn-default dropdown-toggle" data-toggle="dropdown"><i class="icon-options-vertical text-muted"></i></a>
                                  <ul class="dropdown-menu dropdown-menu-right">
                                    <li><a href="#">Edit</a></li>
                                    <li><a href="#">Hide</a></li>
                                    <li><a href="#">Mark</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">Delete</a></li>
                                  </ul>
                                </div>
                              </div><!-- /.timeline-actions -->
                              <p class="media-heading"><strong>Angela Fowler</strong><br><small class="text-muted">Share photo about 2 hours</small></p>
                            </div><!-- /.media-body -->
                          </div><!-- /.media -->

                          <p>Quia laboriosam architecto est quisquam cumque obcaecati quasi voluptas saepe minus nam.</p>
                        </div><!-- /.panel-body -->

                        <a href="#" class="embed-responsive embed-responsive-16by9">
                          <img src="https://lorempixel.com/250/250/nature/8/" alt="embed image" class="embed-responsive-item">
                        </a>

                        <div class="panel-body">
                          <div class="pull-right" data-toggle="tooltip" title="" data-original-title="in this post">
                            <a class="kit-avatar kit-avatar-24 align-middle no-border" href="#">
                              <img alt="avatar" title="friend name" src="https://bootdey.com/img/Content/avatar/avatar1.png">
                            </a>
                            <a class="kit-avatar kit-avatar-24 align-middle no-border" href="#">
                              <img alt="avatar" title="friend name" src="https://bootdey.com/img/Content/avatar/avatar3.png">
                            </a>
                            <a class="kit-avatar kit-avatar-24 align-middle no-border" href="#">
                              <img alt="avatar" title="friend name" src="https://bootdey.com/img/Content/avatar/avatar2.png">
                            </a>
                            <a href="#" class="btn btn-xs btn-default btn-circle">+4</a>
                          </div>
                          <a href="#" class="btn btn-bordered btn-default btn-sm">+12</a>
                          <a href="#" class="btn btn-bordered btn-default btn-sm"><span class="fa fa-share fa-fw"></span> 7</a>
                        </div><!-- /.timeline-resume -->

                        <div class="panel-body timeline-liveliness">
                          <a href="#"><small><i class="fa fa-comment-o fa-fw"></i> View all comments (34)</small></a>
                        </div><!-- /.timeline-liveliness -->
                      </div><!-- /.timeline-panel -->
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>