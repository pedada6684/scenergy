import {createBrowserRouter, RouterProvider} from "react-router-dom";
import ChatPage from "../pages/ChatPage";
import HomePage from "../pages/HomePage";
import NoticePage from "../pages/NoticePage";
import ProfilePage from "../pages/ProfilePage";
import SearchPage from "../pages/SearchPage";
import VideoUploadPage from "../pages/VideoUploadPage";
import Portfolio from "../components/Portfolio/Portfolio";
import RedirectPage from "../components/User/RedirectPage";
import Home2Page from "../pages/Home2Page"
import NotificationPage from "../pages/NotificationPage";
import NewLoginPage from "../pages/NewLoginPage/NewLoginPage";
import ScenergyPage from "../pages/ScenergyPage";
import MyScenergyPost from "../pages/MyScenergyPost";
import MyApplyPage from "../pages/MyApplyPage";
import BookMark from "../pages/BookMark";

export const routes = [
  // { path: "*", element: <App /> },
  {path: "/", element: <NewLoginPage/>},
  { path: "/chat", element: <ChatPage /> },
  { path: "/chat/:roomId", element: <ChatPage /> },
  { path: "/home", element: <HomePage /> },
  { path: "/notice", element: <NoticePage /> },
  {path: "/profile/:userId", element: <ProfilePage/>},
  { path: "/profile/portfolio", element: <Portfolio /> },
  {path: "/scenergy", element: <ScenergyPage/>},
  {path: "/scenergy/mypost", element: <MyScenergyPost/>},
  {path: "/scenergy/myapply", element: <MyApplyPage/>},
  {path: "/scenergy/bookmark", element: <BookMark/>},
  { path: "/search", element: <SearchPage /> },
  { path: "/videoupload", element: <VideoUploadPage /> },
  {path: "/oauth2/redirect", element: <RedirectPage/>},
  {path: "/home2", element: <Home2Page/>},
  {path: "/notification", element: <NotificationPage/>},
];

const router = createBrowserRouter(routes);

const AppRouter = () => {
  return <RouterProvider router={router} />;
};

export default AppRouter;
