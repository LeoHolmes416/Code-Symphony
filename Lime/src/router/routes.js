
const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: 'index', component: () => import('pages/Index.vue') },
      { path: 'treehole', component: () => import('pages/TreeHole')},

    ]
  },
  {
    path: '/gate',
    component: () => import('pages/AccountForm.vue'),
  },
  { path: '/matchfriends', component: () => import('pages/MatchFriends')},

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '*',
    component: () => import('pages/Error404.vue')
  }
]

export default routes
